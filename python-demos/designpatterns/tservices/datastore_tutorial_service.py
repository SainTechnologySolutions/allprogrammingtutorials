from tutorial_service import TutorialService


class DatastoreTutorialService(TutorialService):
    def __init__(self):
        print('Initializing Datastore based TutorialService...')

    @staticmethod
    def get_type():
        return "datastore"

    def get_tutorial_by_id(self, tutorial_id):
        # logic to get tutorial from MySQL
        return "Test Tutorial managed in Datastore"

    def save_tutorial(self, tutorial):
        print("Saved tutorial in Datastore")
