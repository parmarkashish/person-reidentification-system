class Test:

    past_ppl_vector= []

    def set(self):
        folder_vector=[]
        folder_vector.append([1,2,3])
        Test.past_ppl_vector.append(folder_vector)

    def get(self):
        print(Test.past_ppl_vector)