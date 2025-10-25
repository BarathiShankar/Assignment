//Program to use BFS and DFS traversal in the graph
#include<iostream>
#include<queue>
#include<stack>
#include<vector>
using namespace std;
vector<vector<int>> graph;
void BFS()
{
        int key;
        cout<<"Enter the starting index : ";
        cin>>key;
        if(0 > key || key >= graph.size())
        {
                cout<<"Invalid index\nExited from Traversal\n";
                return;
        }
        queue<int> qu;
        int data;
        vector<bool> visited(graph.size(),false);
        visited[key]=true;
        qu.push(key);
        cout<<"BFS Traversal : ";
        while(!qu.empty())
        {
                data = qu.front();
                cout<<data<<" ";
                qu.pop();
                for(int nei : graph[data])
                {
                        if(!visited[nei])
                        {
                                visited[nei]=true;
                                qu.push(nei);
                        }
                }
        }
}
void DFS()
{
        int  key;
        cout<<"Enter the starting index : ";
        cin>>key;
        if(0 > key || key >= graph.size())
        {
                cout<<"Invalid index\nExited from traversal\n";
                return;
        }
        stack<int> st;
        vector<bool> visited(graph.size(),false);
        int data;
        visited[key]=true;
        st.push(key);
        cout<<"DFS Traversal : ";
        while(!st.empty())
        {
                data=st.top();
                cout<<data<<" ";
                st.pop();
                for(int nei : graph[data])
                {
                        if(!visited[nei])
                        {
                                visited[nei]=true;
                                st.push(nei);
                        }
                }
        }
}
void insert()
{
        int n,e,v,u;
        cout<<"Enter the number of nodes : ";
        cin>>n;
        graph.resize(n);
        cout<<"Enter  the number of edges : ";
        cin>>e;
        for(int i=0;i<e;i++)
        {
                cout<<"Enter edge "<<i+1<<" (U V) : ";
                cin>>u>>v;
                if(u>=n || v>=n)
                {
                        cout<<"Invalid index entered\n";
                        continue;
                }
                graph[u].push_back(v);
                graph[v].push_back(u);
        }
}
int main()
{
        insert();
        int o;
        while(1)
        {
                cout<<"Main menu -\n0. Exit program\n1. Perform BFS\n2. Perform DFS\nEnter your choice : ";
                cin>>o;
                switch(o)
                {
                        case 0 : cout<<"Program terminated\n";
                                 exit(0);
                        case 1 : BFS();
                                 break;
                        case 2 : DFS();
                                 break;
                        default : cout<<"Invalid entry, Try again\n";
                }
        }
}
//COMPLETED
