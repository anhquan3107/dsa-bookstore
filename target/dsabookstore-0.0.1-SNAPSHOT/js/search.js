// Function to fetch book suggestions
function searchBooks() {
    const searchBox = document.getElementById('search-box');
    const query = searchBox.value.trim();
    const suggestions = document.getElementById('suggestions');
  
    // Clear suggestions if no query is entered
    if (query.length === 0) {
      suggestions.innerHTML = '';
      return;
    }
  
    // Fetch book suggestions from the server
    fetch('SearchServlet?prefix=' + encodeURIComponent(query))
      .then(response => response.json())
      .then(data => handleSearchResponse(data, suggestions))
      .catch(error => {
        console.error('Error fetching search results:', error);
        suggestions.innerHTML = '<li class="no-results">Error fetching results</li>';
      });
  }
  
  // Handle the search response and display suggestions
  function handleSearchResponse(data, suggestions) {
    suggestions.innerHTML = ''; // Clear existing suggestions
    if (data.status === 'success') {
      const books = data.suggestions;
  
      // If no results found, display a message
      if (books.length === 0) {
        suggestions.innerHTML = '<li class="no-results">No results found</li>';
      } else {
        // Populate the suggestions list
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
  
  // Handle book selection
  function selectBook(book) {
    alert('You selected: ' + book.title);
  }
  