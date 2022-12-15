## Usage

This folder contains all the questions that I have attempted in either Java or Python. The table below contains links that will redirect you to the source code for every question.

## Running the code locally (Java)
1. Add a static keyword to all functions in the class.
2. In the same code file, create a main method which contains a case where the algorithm provided should work.

```
public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2,5,7,9}, 12)));
}
```

3. Compile the code file of interest: `javac '0001. Two Sum.java`
4. Run the file of interest: `java '0001. Two Sum.java`

## Running the code locally (Python)
1. In the same code file, create an instance of the Solution object. Create a command to run the function.

```
instance = Solution()
print(instance.twoSum([2,5,7,9], 12))
```

2. Run the file of interest: `python '0001. Two Sum.py'` / `python3 '0001. Two Sum.py'`