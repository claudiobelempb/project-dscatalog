import { NavContainer } from './styles';
import { NavLink } from '../NavLink';

type LinkProps = {
  title: string;
  href: string;
  target: boolean;
  active: boolean;
};

type NavProps = {
  links: LinkProps[];
};

export const Nav: React.FC<NavProps> = ({ links }) => {
  return (
    <NavContainer>
      {links.map((link, index) => {
        return <NavLink key={index} {...link} />;
      })}
    </NavContainer>
  );
};
