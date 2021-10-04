import { NavContainer } from './styles';
import { LinkDefault } from '../LinkDefault';
import { ReactNode } from 'react';

type NavProps = {
  children: ReactNode;
};

const NavDefault: React.FC<NavProps> = ({ children }) => {
  return <NavContainer>{children}</NavContainer>;
};

export { NavDefault };
