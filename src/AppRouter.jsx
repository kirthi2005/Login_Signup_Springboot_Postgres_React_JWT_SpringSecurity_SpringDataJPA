import { createBrowserRouter, RouterProvider, Outlet } from "react-router-dom";
import Header from "./component/Header";
import Body from "./component/Body";
import Footer from "./component/Footer";
import About from "./component/About";
import Contact from "./component/Contact";
import Error from "./component/Error";
import LoginForm from "./component/LoginForm";
import SignupForm from "./component/SignupForm";
import "./index.css";

const AppLayout = () => {
    return (
      <div className="app">
        <Header />
        <Outlet />
        <Footer />
      </div>
    );
  };

  // Children Routes
const AppRouter = createBrowserRouter([
    {
      path: "/",
      element: <AppLayout />,
      children: [
        {
          path: "/",
          element: <Body />,
        },
        {
          path: "/about",
          element: <About />,
        },
        {
          path: "/contact",
          element: <Contact />,
        },               
      ],
      errorElement: <Error />,
    },
    {
      path: "/login",
      element: <LoginForm/>      
    },
    {
      path: "/register",
      element: <SignupForm/>      
    }
   
  ]);

  export default AppRouter;
