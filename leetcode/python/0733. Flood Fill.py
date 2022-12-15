# Time complexity: O(E+V), where E are the edges and V are the vertices (grids)
# Space complexity: O(E+V)

class Solution(object):
    def floodFill(self, image, sr, sc, color):

        visited = set()
        target = image[sr][sc]

        self.dfs(image, visited, color, sr, sc, target)
        
        return image

    def dfs(self, image, visited, color, row, col, target):
        if (row, col) in visited or row < 0 or col < 0 or row>=len(image) or col>=len(image[0]) or image[row][col] != target:
            return
        visited.add((row, col))
        image[row][col] = color

        self.dfs(image, visited, color, row+1, col, target)
        self.dfs(image, visited, color, row-1, col, target)
        self.dfs(image, visited, color, row, col+1, target)
        self.dfs(image, visited, color, row, col-1, target)