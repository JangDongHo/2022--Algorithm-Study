#include <iostream>
#include <string>

using namespace std;

void ChatBot(int num, int tapCount)
{
    
    string question = "\"재귀함수가 뭔가요?\"";
    string story[3] = {
        "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", 
        "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
        "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
    };
    string lastAnswer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    string said = "라고 답변하였지.";
    
    string tap = "";

    if(num < 0)
    {
        return;
    }
    
    for(int i = 0; i < tapCount; i++)
    {
        tap += "____";
    }
   
   
    cout << tap << question << "\n";
    if(num == 0)
    {
        cout << tap << lastAnswer << "\n";
    }
    else{
        for(int i = 0; i <3; i++)
        {
            cout << tap << story[i] << "\n";
        }
    }
    ChatBot(--num, ++tapCount);
    cout << tap << said << "\n";
}

int main()
{
    int num;
    cin >> num;

    cout << "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    ChatBot(num, 0);

    return 0;
}