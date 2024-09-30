import React, { ReactNode } from 'react'
import { useState, useEffect, useRef } from 'react';

type DropDown = {
  children: ReactNode;
  value: boolean;
  Class: string;
  arrow: boolean
}

export default function DropDown({ children, value, Class, arrow }: DropDown) {
  const [isOpen, setIsOpen] = useState(value);
  const dropdownRef = useRef(null);

  useEffect(() => {
      setIsOpen(value);
  }, [value]);

  const toggleIsOpen = (e: MouseEvent) => {
      e.preventDefault();
      setIsOpen(prevIsOpen => !prevIsOpen);
  };

  const handleClickOutside = (event: MouseEvent) => {
    if (
      dropdownRef.current &&
      !(dropdownRef.current as HTMLDivElement).contains(event.target as Node) ||
      (event.target instanceof HTMLElement && event.target.hasAttribute('data-close-on-click'))
    ) {
      setIsOpen(false);
    }
  };

   useEffect(() => {
    document.addEventListener('mousedown', handleClickOutside);
    return () => {
        document.removeEventListener('mousedown', handleClickOutside);
    };
}, []);

 const arrows = () => {

  if(!arrow) return null

  return (
      isOpen ? 
      <i className="fa-solid fa-angle-up"></i> :
      <i className="fa-solid fa-angle-down"></i>
    )

 }

 return (
  <div ref={dropdownRef} className={`drop-down ${Class || ''} ${isOpen ? 'open' : 'close'}`}>
    {React.Children.map(children, (child, index) => {
      if (index === 0 && React.isValidElement(child)) {
        return React.cloneElement(child as React.ReactElement<any>, {
          onClick: toggleIsOpen,
          children: (
            <>
              {child.props.children}
              {arrows()}
            </>
          ),
        });
      }
      if (index === 1 && React.isValidElement(child)) {
        return React.cloneElement(child as React.ReactElement<any>, {
          onClick: toggleIsOpen,
          className: `drop-down-window ${child.props.className || ""}`,
        });
      }
      return child;
    })}
  </div>
);

}
