n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def isAllPositive(x1, x2, y1, y2):
    for i in range(x1, x2 + 1):
        for j in range(y1, y2 + 1):
            if grid[i][j] <= 0:
                return False
    return True

def solve():
    area = -1
    for x1 in range(n):
        for x2 in range(x1, n):
            for y1 in range(m):
                for y2 in range(y1, m):
                    if isAllPositive(x1, x2, y1, y2):
                        h = x2 - x1 + 1
                        w = y2 - y1 + 1
                        area = max(area, h * w)
    return area

print(solve())