import xmltodict
import yaml


class Parser():
    def __init__(self, xml_string):
        self.xml_string = xml_string
    def parse(self):
        return xmltodict.parse(self.xml_string)

class Converter():
    def __init__(self, data):
        self.data = data
    def convert(self, output):
        yaml.dump(self.data, output, allow_unicode=True)



