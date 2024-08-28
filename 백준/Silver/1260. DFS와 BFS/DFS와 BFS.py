from collections import defaultdict
from collections import deque

# 첫줄 입력
n, m, v = map(int, input().split())

# graph를 defaultdict로. 초기값은 빈 리스트
graph = defaultdict(list)

# 간선 정보 그래프에 저장
for _ in range(m):
  s, e = map(int, input().split())
  graph[s].append(e)
  graph[e].append(s)

# 간선 오름차순 정렬
for node in graph:
    graph[node].sort()

# dfs 재귀로 정의
def dfs(start, visited, graph, result):
  visited[start] = True
  result.append(start)
  for node in graph[start]:
    if not visited[node]:
      dfs(node, visited, graph, result)

# bfs 큐로 정의
def bfs(start, visited, graph, result):
  queue = deque([start])
  visited[start] = True
  while queue:
    node = queue.popleft()
    result.append(node)
    for another_node in graph[node]:
      if not visited[another_node]:
        queue.append(another_node)
        visited[another_node] = True

result_dfs = []
visited = [False] * (n+1)
dfs(v, visited, graph, result_dfs)

visited = [False] * (n+1)
result_bfs = []
bfs(v, visited, graph, result_bfs)

print(*result_dfs)
print(*result_bfs)