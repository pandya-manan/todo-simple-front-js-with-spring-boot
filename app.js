const apiBase = "http://localhost:9200/todo";

// Fetch all todos
function fetchTodos() {
    fetch(apiBase)
        .then(res => res.json())
        .then(todos => {
            const list = document.getElementById("todoList");
            list.innerHTML = "";

            todos.forEach(todo => {
                const li = document.createElement("li");
                li.className = "bg-white p-4 rounded shadow flex justify-between items-center";

                li.innerHTML = `
                    <div>
                        <p class="font-bold">${todo.taskHeadline}</p>
                        <p>${todo.taskDescription}</p>
                    </div>
                    <div class="flex gap-2">
                        <button class="bg-yellow-400 px-3 py-1 rounded hover:bg-yellow-500" onclick="updateTodo(${todo.taskId})">Edit</button>
                        <button class="bg-red-500 px-3 py-1 rounded text-white hover:bg-red-600" onclick="deleteTodo(${todo.taskId})">Delete</button>
                    </div>
                `;
                list.appendChild(li);
            });
        })
        .catch(err => console.error("Error fetching todos:", err));
}

// Create a new todo
document.getElementById("createBtn").addEventListener("click", () => {
    const headline = document.getElementById("headline").value;
    const description = document.getElementById("description").value;

    fetch(apiBase, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ taskHeadline: headline, taskDescription: description })
    })
        .then(res => res.json())
        .then(() => {
            document.getElementById("headline").value = "";
            document.getElementById("description").value = "";
            fetchTodos();
        })
        .catch(err => console.error("Error creating todo:", err));
});

// Delete todo
function deleteTodo(taskId) {
    fetch(`${apiBase}/${taskId}`, { method: "DELETE" })
        .then(() => fetchTodos())
        .catch(err => console.error("Error deleting todo:", err));
}

// Update todo
function updateTodo(taskId) {
    const newHeadline = prompt("Enter new headline:");
    const newDescription = prompt("Enter new description:");

    if (!newHeadline || !newDescription) return;

    fetch(`${apiBase}/${taskId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ taskHeadline: newHeadline, taskDescription: newDescription })
    })
        .then(() => fetchTodos())
        .catch(err => console.error("Error updating todo:", err));
}

// Initial fetch
fetchTodos();
