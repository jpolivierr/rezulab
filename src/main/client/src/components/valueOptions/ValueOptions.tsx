import React from "react";
import {ReactNode } from "react";

type ValueOptions = {
    children: ReactNode;
    isMax: boolean;
    label: string;
    buttonStyle: string;
    add: () => void;
    remove: (index: number) => void;
}

export default function ValueOptions ({
                                children,
                                isMax,
                                label,
                                buttonStyle,
                                add,
                                remove
                            } : ValueOptions
                        )
{
 
    return (
        <>
            {
                React.Children.map(children, (child, index) => {
                    if(React.isValidElement(child)) {
                        return React.cloneElement(child as React.ReactElement<any>, {
                            children: (
                                <>
                                    {child.props.children}
                                    <i onClick={() => remove(index)} className="fa-solid fa-trash-can icon delete-icon"></i>
                                </>
                            )
                        })
                    }
                })
            }
            {
                !isMax && <button 
                                onClick={add} 
                                className={`${buttonStyle}`}
                                >
                                    {label}
                        </button>
            }
        </>
    )

}