import React, { useState } from 'react';

const SearchBar = ({ onSearch }) => {
  const [searchText, setSearchText] = useState('');

  const handleInputChange = (e) => {
    const text = e.target.value;
    setSearchText(text);
    onSearch(text);
  };

  return (
    <input   type="text"  placeholder="Search for Posts"   value={searchText}   onChange={handleInputChange}
    />
  );
};

export default SearchBar;
