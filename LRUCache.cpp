/*

https://www.hackerrank.com/challenges/abstract-classes-polymorphism

*/

#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <algorithm>
#include <set>
#include <cassert>
using namespace std;

struct Node{
   Node* next;
   Node* prev;
   int value;
   int key;
   Node(Node* p, Node* n, int k, int val):prev(p),next(n),key(k),value(val){};
   Node(int k, int val):prev(NULL),next(NULL),key(k),value(val){};
};

class Cache{
   
   protected: 
   map<int,Node*> mp; //map the key to the node in the linked list
   int cp;  //capacity
   Node* tail; // double linked list tail pointer
   Node* head; // double linked list head pointer
   virtual void set(int, int) = 0; //set function
   virtual int get(int) = 0; //get function

};

class LRUCache : public Cache {
    public:    
    LRUCache(int c) {
        tail = NULL;
        head = NULL;
        cp = c;
    }

    int get(int k) {
        auto it = mp.find(k);
        if(it != mp.end()) {
            return it->second->value;
        } else {
            return -1;
        }
    }

    void set(int k, int v) {
        Node* aNode = NULL;
        if(!mp.size()) {
            aNode = new Node(k, v);
            head = aNode;
            tail = aNode;
            mp.insert(make_pair(k, aNode));
        } else {
            auto it = mp.find(k);
            if(it != mp.end()) {
                aNode = it->second;
                if(aNode->value != v) {
                    aNode->value = v;
                }
                if(aNode->prev != NULL && aNode->next != NULL) {
                    aNode->prev->next = aNode->next;
                    aNode->next->prev = aNode->prev;
                    head->prev = aNode;
                    aNode->next = head;
                    aNode->prev = NULL;
                    head = aNode;
                }
                if(aNode->next == NULL) {
                    aNode->next = head;
                    head->prev = aNode;
                    tail = aNode->prev;
                    aNode->prev->next = NULL;
                    aNode->prev = NULL;
                    head = aNode;
                }
            } else {
                aNode = new Node(k ,v);
                if(mp.size() < cp) {
                    aNode->prev = NULL;
                    aNode->next = head;
                    head->prev = aNode;
                    head = aNode;
                    mp[k] = aNode;
                } else {
                    aNode->next = head;
                    head->prev = aNode;
                    head = aNode;
                    mp[k] = aNode;
                    int tail_key = tail->key;
                    mp.erase(mp.find(tail_key));
                    tail = tail->prev;
                    tail->next = NULL;
                }
            }
        }
    }
};

int main() {
   int n, capacity,i;
   cin >> n >> capacity;
   LRUCache l(capacity);
   for(i=0;i<n;i++) {
      string command;
      cin >> command;
      if(command == "get") {
         int key;
         cin >> key;
         cout << l.get(key) << endl;
      } 
      else if(command == "set") {
         int key, value;
         cin >> key >> value;
         l.set(key,value);
      }
   }
   return 0;
}
