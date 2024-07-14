def solution(n, words):
    answer = [0, 0]
    length = len(words)
    used_words = set()
    used_words.add(words[0])
    
    for i in range(1, length):

        if words[i] in used_words or words[i][0] != words[i-1][-1]:
            person = (i % n) + 1
            order = (i // n) + 1
            return [person, order]
        
        used_words.add(words[i])
    
    return answer
