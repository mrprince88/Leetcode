class MyCircularQueue {
    
    int n,front,rear;
    int []q;

    public MyCircularQueue(int k) {
        n=k;
        q=new int[n];
        front=rear=-1;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        if(front==-1) {
            front++; rear++;
        }
        else if(rear==n-1 && front>0)
            rear=0;
        else
            rear++;
        q[rear]=value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        if(front==rear) {
            front=-1;
            rear=-1;
        }
        else if(front==n-1)
            front=0;
        else 
            front++;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return q[rear];
    }
    
    public boolean isEmpty() {
        return front==-1;
    }
    
    public boolean isFull() {
        return (front==0 && rear==n-1) || front==rear+1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */