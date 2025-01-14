import re

# Вспомогательная функция для привода словаря к нормальному виду
def rem(dic: dict) -> dict:
    keys = []
    try:
        for el in dic:
            keys.append(*[key for key, value in el.items()])
        if len(keys) == len(set(keys)):
            newdic = dict()
            for el in dic:
                for key, value in el.items():
                    newdic[key] = value
            return newdic
    except Exception as e:
        pass
    return dic

# Вспомогательная функция для конвертации .xml файла в строку
def prepare(text: str) -> str:
    text = text.replace("\n", "")
    while "> " in text or "< " in text:
        text = text.replace("> ", ">").replace(" <", "<")
    return text

# Конвертация .xml файла в словарь
def xml_to_dict(text: str):
    text = prepare(text)
    out = []
    if text[0] not in [">", "<"]:
        return text
    i = 0
    while i < len(text):
        if text[i] == "<" and text[i+1] != "/":
            for en in range(i, len(text)):
                if text[en] == ">":
                    tag = text[i+1:en]
                    break
            for _ in range(i+len(tag), len(text)):
                if text[_:_+3+len(tag)] == f"</{tag}>":
                    newtext = text[i+len(tag)+2:_]
                    val = xml_to_dict(newtext)
                    out.append({tag: val})
                    i = _+2+len(tag)
                    break
        i += 1
    if len(out) == 1:
        return out[0]
    else:
        return rem(out)

# Конвертация словаря в вид .yaml
def recursive_replacing(data, f,  deep=0):
    for key, value in data.items():
        if type(value) == dict:
            f.write('\n' + ' ' * 2 * deep + key + ':')
            recursive_replacing(value, f, deep+1)
        elif type(value) == list:
            f.write('\n' + ' ' * 2 * deep + key + ':')
            for el in value:
                recursive_replacing(el, f, deep+1)
        else:
            f.write('\n' + ' '*2*deep + key + ': ' + value)




# Создание и заполнение .yaml файла
def dict_to_yaml(data):
    with open("output/schedule.yml", "w+") as f:
        recursive_replacing(data, f, deep=0)

# Вспомогательная функция для конвертации с использованием регулрных выражений
def via_regex(text, deep = 0):
    deep -= 1 # Просто костыль
    match = re.search(r"<(\w+)>(.*?)<\/\1>", text)
    if match:
        if match.group(1) == 'root':
            return re.sub(r"<(\w+)>(.*?)<\/\1>", r"\2", text)
        if '<' in str(match.group(2)) or '>' in str(match.group(2)):
            return re.sub(r"<(\w+)>(.*?)<\/\1>", '\n' + " " * 2 * deep + r"\1: \2 \n", text)
    return re.sub(r"<(\w+)>(.*?)<\/\1>", '\n'+" "*2*deep + r"\1: \2 \n", text)

# Конвертация при помощи регулярных выражений
def convert_xml_to_yaml(xml_string):
    deep = 0
    xml_string = prepare(xml_string)
    while len(re.findall(r"<(.*?)>", xml_string)) != 0:
        xml_string = via_regex(xml_string, deep)
        deep += 1
        while '\n\n' in xml_string:
            xml_string = xml_string.replace('\n\n', '\n')
        while '\n \n' in xml_string:
            xml_string = xml_string.replace('\n \n', '\n')
    with open('output/schedule_regex.yml', 'w+') as f:
        f.write(xml_string)

