from abc import abstractmethod


class TutorialService(object):
    def __init__(self):
        print('Initializing Abstract TutorialService...')

    @staticmethod
    def get_type():
        pass

    @abstractmethod
    def get_tutorial_by_id(self, tutorial_id):
        pass

    @abstractmethod
    def save_tutorial(self, tutorial):
        pass
