import { NavContainer } from './styles';
import { LinkDefault } from '../LinkDefault';

type LinkProps = {
  title: string;
  href: string;
  target: boolean;
  active: boolean;
};

type NavProps = {
  links: LinkProps[];
};

const NavDefault: React.FC<NavProps> = ({ links }) => {
  return (
    <NavContainer>
      {links.map((link, index) => {
        return (
          <LinkDefault
            linkOnClick={() => console.log('Click')}
            key={index}
            {...link}
          />
        );
      })}
    </NavContainer>
  );
};

export { NavDefault };
