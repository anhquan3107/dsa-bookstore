
function searchBooks() {
    const searchBox = document.getElementById('search-box');
    const query = searchBox.value.trim();
    const suggestions = document.getElementById('suggestions');
  

    if (query.length === 0) {
      suggestions.innerHTML = '';
      return;
    }
  
    fetch('SearchServlet?prefix=' + encodeURIComponent(query))
      .then(response => response.json())
      .then(data => handleSearchResponse(data, suggestions))
      .catch(error => {
        console.error('Error fetching search results:', error);
        suggestions.innerHTML = '<li class="no-results">Error fetching results</li>';
      });
  }
  

  function handleSearchResponse(data, suggestions) {
    suggestions.innerHTML = ''; 
    if (data.status === 'success') {
      const books = data.suggestions;
  
      
      if (books.length === 0) {
        suggestions.innerHTML = '<li class="no-results">No results found</li>';
      } else {
        
        books.forEach(book => {
          const li = document.createElement('li');
          li.className = 'suggestion-item';
          li.textContent = book.title + ' by ' + book.author + ' - $' + book.price;
          li.onclick = () => selectBook(book);
          suggestions.appendChild(li);
        });
      }
    } else {
      suggestions.innerHTML = '<li class="no-results">No results found</li>';
    }
  }
  
  function selectBook(book) {
    alert('You selected: ' + book.title);
  }
  