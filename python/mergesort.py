def merge(arr, l, m, r):
    n1 = m - l + 1
    n2 = r - m
    L, R = [], []
    for i in range(0, n1):
        L.append(arr[l + i])
    for i in range(0, n2):
        R.append(arr[m + 1 + i])
    i, j, k = 0, 0, l
    while i < n1 and j < n2:
        if L[i] < R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1
    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1

def mergeSort(arr, l, r):
    if l < r:
        m = int((l + r) / 2)
        mergeSort(arr, l, m)
        mergeSort(arr, m + 1, r)
        merge(arr, l, m, r)

def main():
    arr = [9, 7, 6, 15, 16, 5, 10, 11]
    mergeSort(arr, 0, len(arr) - 1)
    print(arr)

if __name__ == '__main__':
    main()
