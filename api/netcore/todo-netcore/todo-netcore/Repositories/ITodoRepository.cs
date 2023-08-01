using TodoNETCore.Data;

namespace TodoNETCore.Repositories
{
    public interface ITodoRepository
    {
        Task<TodoItem> FindById(long id);
        Task<IEnumerable<TodoItem>> FindByStatus(String status);
        Task<IEnumerable<TodoItem>> FindAll();
        void Insert(TodoItem item);
        void Update(TodoItem item);
        void Delete(TodoItem item);

    }
}
