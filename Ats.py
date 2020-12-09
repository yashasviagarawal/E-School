import docx2txt
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity


resume = docx2txt.process("resume.docx")
y=[",","."]
for i in  y:
    re = resume.split(i)
    for i in re:
        print(i)
        print("\n")

jobdecs = docx2txt.process("job.docx")
print(jobdecs)

text = [resume, jobdecs]
cv = CountVectorizer()
count_matrix = cv.fit_transform(text)
print(cosine_similarity(count_matrix))

match = cosine_similarity(count_matrix)[0][1]
match = match*100
match = round(match,2)
print(match)

if(match>60):
    {
    print("application is accepted")

}
else:
    {
    print("aplication is rejected")
}

