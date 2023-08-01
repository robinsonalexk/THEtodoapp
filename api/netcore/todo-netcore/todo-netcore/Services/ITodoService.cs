using TodoNETCore.Data;

namespace TodoNETCore.Services
{
    public interface ITodoService
    {
        Task<IEnumerable<TodoItem>> GetAllTodoItems();
        Task<TodoItem> GetTodoItem(long id);
        Task<IEnumerable<TodoItem>> GetTodoItemByStatus(string status);
        void AddTodoItem(TodoItem item);
        void UpdateTodoItem(TodoItem item);
        void DeleteTodoItem(int id);
    }
}
