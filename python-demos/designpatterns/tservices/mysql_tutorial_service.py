from tutorial_service import TutorialService


class MySqlTutorialService(TutorialService):
    def __init__(self):
        print('Initializing MySQL based TutorialService...')

    @staticmethod
    def get_type():
        return "mysql"

    def get_tutorial_by_id(self, tutorial_id):
        # logic to get tutorial from MySQL
        return "Test Tutorial managed in MySql"

    def save_tutorial(self, tutorial):
        print("Saved tutorial in MySql")
