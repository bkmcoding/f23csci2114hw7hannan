# 137846528820

# VERY OLD CODE FROM 2024

# # # Calculate the number of routes for a 20x20 grid
grid_size = 20
# routes = calculate_routes(grid_size)
# print(f"The number of routes through a {grid_size}x{grid_size} grid is: {routes}")

grid = []
for i in range(grid_size + 1):
      grid.append([])
      for j in range(grid_size + 1):
        grid[i].append(1)

for i in range(1, grid_size + 1):
        for j in range(1, grid_size + 1):
            grid[i][j] = grid[i-1][j] + grid[i][j-1]
# for i in range(len(grid)):
#      print(grid[i])
print(grid[grid_size][grid_size])

# print(grid)
# print(grid[i][j])

# def convertBinary(gridCount):
#     gridNum = gridSize
#     result = ""
#     bIndex = 1
#     while (gridNum >= (bIndex * 2)):
#         bIndex *= 2
#     result += "1"
#     gridNum -= bIndex
#     while (bIndex != 1):
#         bIndex /= 2
#         if (bIndex <= gridNum):
#             result += "1"
#             gridNum -= bIndex
#         else:
#             result += "0"
#     return result

# def countBinaryVariation(originalBinary):
#     newBinary = originalBinary
#     Count = 0
#     for i in range(len(originalBinary)):
#         newBinary



# if __name__ == "__main__":
#     binary = convertBinary(gridSize * gridSize)
#     print(binary)
