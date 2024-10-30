The lifecycle of a thread in Java consists of several distinct stages that define how it transitions from creation to completion. Each stage corresponds to a specific state in the thread’s lifecycle, and understanding these states helps developers manage thread behavior efficiently. 

Here is a breakdown of each state in the Java thread lifecycle:

---

### 1. **New State**

- **Definition**: When a thread is created but not yet started, it is in the **New** state.
- **How It’s Created**:
    - By creating a new instance of the `Thread` class or a class implementing `Runnable`.
    - In this state, the thread is just an object, not yet capable of independent execution.
- **Example**:
    ```java
    Thread thread = new Thread(new MyRunnable());
    // At this point, thread is in the New state.
    ```
- **Behavior**: No resources are allocated, and the thread is not scheduled for execution.
- **Transition to Next State**: It transitions to the **Runnable** state when `start()` is called.

---

### 2. **Runnable State**

- **Definition**: After calling `start()`, the thread enters the **Runnable** state. This means it is eligible for running by the Java thread scheduler, although it might not start immediately.
- **Key Characteristics**:
    - The thread is alive and ready to run.
    - The thread scheduler decides when it will actually start executing, depending on factors like CPU availability and thread priority.
- **Example**:
    ```java
    thread.start(); // Now the thread is in the Runnable state.
    ```
- **Transition Conditions**:
    - If the scheduler allocates CPU time to the thread, it will enter the **Running** state.
    - If the scheduler does not select it immediately, it remains in the **Runnable** state.

---

### 3. **Running State**

- **Definition**: A thread enters the **Running** state when it starts executing its `run()` method.
- **Key Characteristics**:
    - This is the state in which the thread performs its intended work.
    - The `run()` method runs until it either completes or the thread is interrupted by methods like `sleep()`, `yield()`, or `wait()`.
- **Transition Conditions**:
    - If the `run()` method completes, the thread moves to the **Terminated** state.
    - If the thread is paused or waiting, it transitions to the appropriate waiting or sleeping state.

---

### 4. **Blocked State**

- **Definition**: A thread enters the **Blocked** state when it tries to access a synchronized resource currently held by another thread.
- **Key Characteristics**:
    - The thread is alive but not eligible for running as it waits for a lock on a synchronized block or method.
    - It will remain in this state until it acquires the required lock.
- **Example**:
    ```java
    synchronized(lockObject) {
        // Only one thread at a time can enter this block
    }
    ```
- **Transition Conditions**:
    - Once the lock becomes available, the thread will transition back to the **Runnable** state.
    - The scheduler will eventually move it to the **Running** state when CPU resources are available.

---

### 5. **Waiting State**

- **Definition**: A thread enters the **Waiting** state when it pauses execution indefinitely until another thread performs a specific action to wake it up.
- **Common Methods Leading to Waiting**:
    - `Object.wait()`
    - `Thread.join()` without a timeout.
    - `LockSupport.park()`
- **Example**:
    ```java
    synchronized(lock) {
        lock.wait(); // Thread will wait until notified
    }
    ```
- **Transition Conditions**:
    - A waiting thread can be moved back to the **Runnable** state if:
      - Another thread calls `notify()` or `notifyAll()` on the object it’s waiting on.
      - The thread it’s waiting to join completes (if `join()` was used).
  
---

### 6. **Timed Waiting State**

- **Definition**: A thread is in the **Timed Waiting** state if it’s waiting for a specific period. It automatically moves out of this state after the specified time passes or if an interrupt occurs.
- **Common Methods Leading to Timed Waiting**:
    - `Thread.sleep(long millis)`
    - `Object.wait(long timeout)`
    - `Thread.join(long millis)`
    - `LockSupport.parkNanos(long nanos)`
    - `LockSupport.parkUntil(long deadline)`
- **Example**:
    ```java
    try {
        Thread.sleep(1000); // Thread will sleep for 1 second
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    ```
- **Transition Conditions**:
    - Once the timer expires or if it’s interrupted, the thread transitions back to the **Runnable** state.
    - The scheduler then decides when to transition it to the **Running** state.

---

### 7. **Terminated (Dead) State**

- **Definition**: A thread enters the **Terminated** state when it has finished executing, either because its `run()` method completed normally or an uncaught exception caused the termination.
- **Key Characteristics**:
    - Once a thread reaches this state, it cannot be restarted. The `start()` method can only be called once per thread.
- **Example**:
    ```java
    thread.start();
    // After run() finishes, the thread reaches Terminated state
    ```
- **Transition Conditions**:
    - A thread can only reach the **Terminated** state from the **Running** state after the `run()` method completes.
    - If the thread’s execution is interrupted by an exception, it also enters the **Terminated** state.

---

### Visual Summary of Thread Lifecycle

```plaintext
          +-------------------------+
          |         NEW             |
          +-------------------------+
                    |
                  start()
                    |
                    v
          +-------------------------+
          |       RUNNABLE          |<--------------+
          +-------------------------+               |
                    |                               |
                    |                               |
                    v                               |
          +-------------------------+               |
          |        RUNNING          |               |
          +-------------------------+               |
          |      |         |        |               |
      sleep(), yield(),     |        | synchronized lock
      wait()                 v        |
          +-----------+     +----------------------+
          |BLOCKED    |     | WAITING / TIMED WAITING |
          +-----------+     +----------------------+
                    |
                    |
                    v
          +-------------------------+
          |      TERMINATED         |
          +-------------------------+
```

---

### Key Points to Remember

1. **Starting a Thread**: A thread must go through `start()` to become eligible for running. Simply calling `run()` directly does not start a new thread; it will execute as a normal method call.
   
2. **Waiting vs. Timed Waiting**: `Waiting` is indefinite and requires an explicit wake-up action, whereas `Timed Waiting` has a fixed duration.

3. **Blocked State**: Threads enter the `Blocked` state when waiting for locks; it’s an essential concept for managing synchronized blocks or methods.

4. **Termination**: Once a thread completes, it enters the `Terminated` state, from which it cannot restart. 

Understanding these states and transitions helps in developing applications that need multithreading and synchronization, optimizing performance and preventing issues like deadlocks and race conditions.