import { NavMobileContainer } from './styles';
import { LinkDefault } from '../LinkDefault';

type NavMobileProps = {
  title: string;
  href: string;
  target: boolean;
  active: boolean;
};

type NavProps = {
  links: NavMobileProps[];
};

export const Nav: React.FC<NavProps> = ({ links }) => {
  return (
    <NavMobileContainer>
      {links.map((link, index) => {
        return <LinkDefault key={index} {...link} />;
      })}
    </NavMobileContainer>
  );
};
