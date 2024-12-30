n = int(input())
size = list(map(int, input().split()))
t, p = map(int, input().split())

shirts = 0
for s in size:
    if s == 0:
        continue
    elif s <= t:
        shirts += 1
    elif s % t == 0:
        shirts += (s // t)
    else:
        shirts += (s // t) + 1

# 펜 묶음과 낱개 계산
print(shirts)
print(n//p, n%p)