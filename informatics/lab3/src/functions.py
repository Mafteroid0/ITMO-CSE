import re

# smile pattern: ;<{=

def count_smiles(string: str) -> int:
    return len(re.findall(r";<{=", string))

def remove_dublicate(text: str) -> str:
    return re.sub(r"(\w+)\s\1\b", r"\1", text, flags=re.IGNORECASE)

def pick_a_word(letters: str, distance: int, text: str):

    distance = str(distance)
    # default pattern is "\b[^{ABC}\s\n]*[A][^{ABC}]{1}[B][^{ABC}]{1}[C][^{ABC}\s\n]*\b" (with 'A', 'B', 'C' letters)
    pattern = (r"\b[^{"+letters+r"}\s\n]*["+letters[0]+r"][^{"+letters+r"}]{"
               +distance+r"}["+letters[1]+r"][^{"+letters+r"}]{"+distance+r"}["
               +letters[2]+r"][^{"+letters+r"}\s\n]*\b")
    return re.findall(pattern, text, re.IGNORECASE)

