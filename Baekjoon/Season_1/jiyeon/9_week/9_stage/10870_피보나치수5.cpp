#include <iostream>

using namespace std;

int GetFibonacci(int n)
{
    if(n == 0)
    {
        return 0;
    }
    if(n == 1)
    {
        return 1;
    }
    return GetFibonacci(n-1) + GetFibonacci(n-2);
}

int main()
{
    int num;
    cin >> num;

    cout << GetFibonacci(num);
    return 0;
}