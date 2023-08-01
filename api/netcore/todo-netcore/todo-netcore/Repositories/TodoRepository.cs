using Microsoft.EntityFrameworkCore;
using TodoNETCore.Data;

namespace TodoNETCore.Repositories
{
    public class TodoRepository : ITodoRepository
    {
        private readonly TodoDbContext _context;

        public TodoRepository(TodoDbContext context) 
        { 
            _context = context; 
        }

        public async Task<TodoItem> FindById(long id)
        {
            return await _context.TodoItems.FirstAsync(x => x.Id == id);
        }

        public async Task<IEnumerable<TodoItem>> FindAll()
        {
            return await _context.TodoItems.ToListAsync();
        }

        public async Task<IEnumerable<TodoItem>> FindByStatus(string status)
        {
            return await _context.TodoItems.Where(x => x.Status == status).ToListAsync();
        }

        public void Insert(TodoItem item)
        {
            _context.TodoItems.Add(item);
            _context.SaveChanges();
        }

        public void Update(TodoItem item)
        {
            throw new NotImplementedException();
        }

        public void Delete(TodoItem item)
        {
            throw new NotImplementedException();
        }
    }
}
