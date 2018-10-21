from abc import abstractmethod


class TutorialService(object):
    def __init__(self):
        print('Initializing Abstract TutorialService...')

    @staticmethod
    def get_type():
        """
        Defines unique type of this service.
        """
        pass

    @abstractmethod
    def get_tutorial_by_id(self, tutorial_id):
        """
        Gets the tutorial for input tutorial id.
        """
        pass

    @abstractmethod
    def save_tutorial(self, tutorial):
        """
        Saves the tutorial in underlying store.
        """
        pass
