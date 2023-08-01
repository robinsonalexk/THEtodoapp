using Microsoft.AspNetCore.Mvc;
using TodoNETCore.Data;
using TodoNETCore.Services;

namespace TodoNETCore.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class TodoController : ControllerBase
    {
        private readonly ITodoService _todoService;
        public TodoController(ITodoService todoService) 
        { 
            _todoService = todoService;
        }

        [HttpGet]
        public async Task<IActionResult> GetTodoItemById(long id)
        {
            return Ok(await _todoService.GetTodoItem(id));
        }

        [HttpPost]
        public async Task<IActionResult> AddTodoItem([FromBody] TodoItem request)
        {
            _todoService.AddTodoItem(request);
            return Ok("Success");
        }
    }
}
