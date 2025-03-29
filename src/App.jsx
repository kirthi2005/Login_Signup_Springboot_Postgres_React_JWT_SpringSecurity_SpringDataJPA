
import React from 'react';
import { RouterProvider } from 'react-router-dom';
import AppRouter from './AppRouter'; // Import the defined routes
import './index.css';

function App() {
  return (
    <div>
      {/* Provide the router configuration to RouterProvider */}
      <RouterProvider router={AppRouter} />
    </div>
  );
}

export default App;
 