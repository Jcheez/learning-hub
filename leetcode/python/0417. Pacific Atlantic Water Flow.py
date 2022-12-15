# Time complexity: O(NM)
# Space complexity: O(NM)

class Solution(object):
    def pacificAtlantic(self, heights):
        
        pac = set()
        atl = set()

        for r in range(len(heights)):
            self.dfs(r, 0, heights, pac, heights[r][0])
            self.dfs(r, len(heights[0])-1,heights, atl, heights[r][len(heights[0])-1])

        for c in range(len(heights[0])):
            self.dfs(0, c, heights, pac, heights[0][c])
            self.dfs(len(heights)-1, c, heights, atl, heights[len(heights)-1][c])

        return pac.intersection(atl)

    def dfs(self, row, col, heights, visited, prev):
        if row<0 or col<0 or row>=len(heights) or col>=len(heights[0]) or (row, col) in visited or heights[row][col] < prev:
            return
        visited.add((row, col))
        self.dfs(row-1, col, heights, visited, heights[row][col])
        self.dfs(row+1, col, heights, visited, heights[row][col])
        self.dfs(row, col-1, heights, visited, heights[row][col])
        self.dfs(row, col+1, heights, visited, heights[row][col])