// Footer component for footer section
const Footer = () => {
    const year = new Date().getFullYear();
    return (
      <div className="footer">
        Created By Kiruthika
        <i className="fa-solid fa-copyright"></i>
        {" " + year}
        <strong>
           <span>KKVR Hospital</span>
        </strong>
      </div>
    );
  };
  
  export default Footer;