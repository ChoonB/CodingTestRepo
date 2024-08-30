n = int(input())

table = [tuple(map(int, input().split())) for _ in range(n)]

dp = [0] * (n+1)

for day in range(n):
  time, pay = table[day]
  if time+day <= n:
    dp[time+day] = max(dp[time+day], dp[day]+ pay)
  dp[day+1] = max(dp[day+1], dp[day])

print(dp[n])