using TodoNETCore.Data;
using TodoNETCore.Repositories;

namespace TodoNETCore.Services
{
    public class TodoService : ITodoService
    {
        private readonly ITodoRepository _todoRepository;

        public TodoService(ITodoRepository todoRepository)
        {
            _todoRepository = todoRepository;
        }
        public async Task<TodoItem> GetTodoItem(long id)
        {
            return await _todoRepository.FindById(id);
        }

        public async Task<IEnumerable<TodoItem>> GetAllTodoItems()
        {
            throw new NotImplementedException();
        }

        public async Task<IEnumerable<TodoItem>> GetTodoItemByStatus(string status)
        {
            throw new NotImplementedException();
        }

        public async void AddTodoItem(TodoItem item)
        {
            _todoRepository.Insert(item);
        }

        public void UpdateTodoItem(TodoItem item)
        {
            throw new NotImplementedException();
        }

        public void DeleteTodoItem(int id)
        {
            throw new NotImplementedException();
        }

    }
}
