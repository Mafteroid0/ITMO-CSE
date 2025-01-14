from tools import xml_to_dict, dict_to_yaml, convert_xml_to_yaml
import xmltodict
import yaml
import formal
import time
import os
try: 
    os.makedirs("./output")
except OSError:
    if not os.path.isdir("./output"):
        raise


xml_file = open('schedule.xml')
xml_string = xml_file.read()


 
# Конвертация вручную
start = time.time()
for _ in range(100):
    data = xml_to_dict(xml_string)
    dict_to_yaml(data)
print("Вручную:", time.time() - start)


 
# Конвертация с использованием готовых библиотек
start = time.time()
for _ in range(100):
    data = xmltodict.parse(xml_string)
    with open("output/schedule_auto.yml", "w") as output:
        yaml.dump(data, output, allow_unicode=True)
print("С библиотеками:", time.time() - start)


 
# Конвертация с использованием регулярных выражений
start = time.time()
for _ in range(100):
    convert_xml_to_yaml(xml_string)
print("С Регулярными выражениями:", time.time() - start)


 
#
start = time.time()
for _ in range(100):
    parser = formal.Parser(xml_string)
    data = parser.parse()
    converter = formal.Converter(data)
    with open("output/schedule_formal.yml", "w") as output:
        converter.convert(output)
print("С формальными грамматикам:", time.time() - start)
