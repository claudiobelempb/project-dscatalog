import { NavMobileContainer } from './styles';
import { LinkDefault } from '../LinkDefault';

type NavMobileProps = {
  title: string;
  href: string;
  target: '_blank' | '_self';
  active: boolean;
};

type NavProps = {
  links: NavMobileProps[];
};

export const Nav: React.FC<NavProps> = ({ links }) => {
  return (
    <NavMobileContainer>
      {links.map((link, index) => {
        return (
          <LinkDefault
            linkOnClick={() => console.log('NavMobile')}
            key={index}
            {...link}
          />
        );
      })}
    </NavMobileContainer>
  );
};
