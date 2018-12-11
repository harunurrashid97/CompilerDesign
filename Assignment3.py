def graph_input():
    V = int(input("Enter the number of Nodes: "))
    E = int(input("Enter the number of Edges: "))

    print ("Enter Edges with weights:\n")

    adj_matrix = []
 # vertex numbering starts from 0
    for i in range(0, V):
        temp = []
        for j in range(0, V):
            temp.append(0)
        adj_matrix.append(temp)
    
    for i in range(0, E):
        s = input()
        u, v, w = s.split()
        u = int(u)
        v = int(v)
        w = int(w)
        adj_matrix[v][u] = adj_matrix[u][v] = w

 # print the adjacency matrix
    for i in range (0, V):
        print (adj_matrix[i])

    return adj_matrix

graph = graph_input()
