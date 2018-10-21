from tservices import *


class TutorialServiceFactory:
    def __init__(self):
        # Get all subclasses of TutorialService
        subclasses = TutorialService.__subclasses__()
        # Initialize classes object where subclasses will be stored along with type
        self.classes = {}
        for subclass in subclasses:
            # Add type as key and subclass as value in classes object
            self.classes[subclass.get_type()] = subclass

    def get_tutorial_service(self, type):
        # Get class object corresponding to input type
        return self.classes[type]


tutorial_service_factory = TutorialServiceFactory()
print(tutorial_service_factory.get_tutorial_service("mysql"))
print(tutorial_service_factory.get_tutorial_service("datastore"))
print(tutorial_service_factory.get_tutorial_service("filesystem"))
