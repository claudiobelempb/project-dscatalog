import { ReactDOM } from 'react';
import Link, { LinkProps } from 'next/link';
import { LinkContainer } from './styles';

type ILinkProps = React.PropsWithChildren<LinkProps> & {
  icon?: ReactDOM;
  title: string;
  target?: '_blank' | '_self';
  linkOnClick?: () => void;
  active?: string;
};

type NavProps = {
  links?: ILinkProps[];
};

type IProps = ILinkProps & NavProps;

export const LinkDefault: React.FC<IProps> = ({
  href,
  title,
  target = '_blank',
  linkOnClick,
  icon,
  active,
  links,
  children,
}) => {
  const renderLinkDefault = () => {
    return links ? (
      links.map((link, index) => (
        <Link href={href} key={index}>
          <a
            title={link.title}
            className={`${link.active}`}
            target={link.target}
          >
            {link.icon}
            {link.title}
            {link.children}
          </a>
        </Link>
      ))
    ) : (
      <Link href={href}>
        <a title={title} className={`${active}`} target={target}>
          {icon}
          {title}
          {children}
        </a>
      </Link>
    );
  };

  return renderLinkDefault();
};
