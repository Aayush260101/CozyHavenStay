import React, { useEffect, useState } from 'react';
import BCard from './BCard';
import ConfirmDeleteModal from './ConfirmDeleteModal';

const App = () => {
  const [books, setBooks] = useState([]);
  const [sbooks, setSbooks] = useState([]);
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);  // modal open state
  const [bookToDelete, setBookToDelete] = useState(null);  // book to delete

  useEffect(() => {
    setSbooks(books.filter((temp) => temp.bookTitle.includes(search)));
  }, [search, books]);

  useEffect(() => {
    const fetchData = async () => {
      const url = 'https://all-books-api.p.rapidapi.com/getBooks';
      const options = {
        method: 'GET',
        headers: {
          'x-rapidapi-key': 'YOUR_API_KEY',  // Use your API key
          'x-rapidapi-host': 'all-books-api.p.rapidapi.com',
        },
      };

      try {
        const response = await fetch(url, options);
        const result = await response.json();
        setBooks(result); 
      } catch (error) {
        console.error(error);
      }
    };

    fetchData();
  }, []);

  const deleteBook = (bookIsbn) => {
    setBooks(books.filter((temp) => temp.bookIsbn !== bookIsbn));
    setOpen(false);  // Close the modal after deletion
  };

  const openDeleteModal = (bookIsbn) => {
    setBookToDelete(bookIsbn);  // Set the book to delete
    setOpen(true);  // Open the modal
  };

  return (
    <>
      <div>
        <input type="text" placeholder="Enter Book Title" onChange={(event) => setSearch(event.target.value)} />
      </div>
      <div>
        <p>Total Books: {books.length}</p>
        {search.length === 0 ? (
          books.map((book, index) => (
            <BCard
              key={index}
              bookIsbn={book.bookIsbn}
              bookTitle={book.bookTitle}
              bookImage={book.bookImage}
              bookAuthor={book.bookAuthor}
              bookDescription={book.bookDescription}
              deleteBook={() => openDeleteModal(book.bookIsbn)}  // Open the delete modal
            />
          ))
        ) : (
          sbooks.map((book, index) => (
            <BCard
              key={index}
              bookIsbn={book.bookIsbn}
              bookTitle={book.bookTitle}
              bookImage={book.bookImage}
              bookAuthor={book.bookAuthor}
              bookDescription={book.bookDescription}
              deleteBook={() => openDeleteModal(book.bookIsbn)}  // Open the delete modal
            />
          ))
        )}
      </div>
      <ConfirmDeleteModal 
        open={open} 
        setOpen={setOpen} 
        bookToDelete={bookToDelete} 
        deleteBook={deleteBook} 
      />
    </>
  );
};

export default App;
