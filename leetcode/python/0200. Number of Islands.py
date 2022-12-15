# Time complexity: O(RC) where R is the num of rows, C is the number of cols
# Space complexity: O(RC) where R is the num of rows, C is the number of cols

class Solution(object):
    def numIslands(self, grid):
        row = len(grid)
        col = len(grid[0])
        islands = 0

        visited = [[0 for _ in range(col)] for _ in range(row)]
        
        for r in range(row):
            for c in range(col):
                if visited[r][c] == 0 and grid[r][c] == "1":
                    self.dfs(r,c,visited, grid)
                    islands += 1
        return islands

    def dfs(self, row, col, visited, grid):
        r = len(visited)
        c = len(visited[0])

        if row >=0 and col>=0 and row<r and col<c and visited[row][col] == 0 and grid[row][col] == "1":
            visited[row][col] = 1
            self.dfs(row-1, col, visited, grid)
            self.dfs(row+1, col, visited, grid)
            self.dfs(row, col-1, visited, grid)
            self.dfs(row, col+1, visited, grid)
