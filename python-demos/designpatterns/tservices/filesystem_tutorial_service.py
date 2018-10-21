from tutorial_service import TutorialService


class FileSystemTutorialService(TutorialService):
    def __init__(self):
        print('Initializing FileSystem based TutorialService...')

    @staticmethod
    def get_type():
        return "filesystem"

    def get_tutorial_by_id(self, tutorial_id):
        # logic to get tutorial from MySQL
        return "Test Tutorial managed in File System"

    def save_tutorial(self, tutorial):
        print("Saved tutorial in File System")
