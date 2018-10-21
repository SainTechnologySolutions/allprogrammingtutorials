from tservices import *


class TutorialServiceFactory:
    def __init__(self):
        subclasses = TutorialService.__subclasses__()
        self.classes = {}
        for subclass in subclasses:
            self.classes[subclass.get_type()] = subclass

    def get_tutorial_service(self, type):
        return self.classes[type]


tutorial_service_factory = TutorialServiceFactory()
print(tutorial_service_factory.get_tutorial_service("mysql"))
print(tutorial_service_factory.get_tutorial_service("datastore"))
print(tutorial_service_factory.get_tutorial_service("filesystem"))
