import { ReactDOM } from 'react';
import Link from 'next/link';
import { LinkContainer } from './styles';
import { ReactNode } from 'react';

type LinkProps = {
  icon?: ReactDOM;
  title: string;
  href: string;
  target?: '_blank' | '_self';
  linkOnClick?: () => void;
  active?: string;
  children?: ReactNode;
};

type NavProps = {
  links?: LinkProps[];
};

type Props = LinkProps & NavProps;

export const LinkDefault: React.FC<Props> = ({
  title,
  href,
  target,
  linkOnClick,
  icon,
  active,
  links,
  children,
}: Props) => {
  const renderLinkDefault = () => {
    return links ? (
      links.map((link, index) => (
        <LinkContainer key={index} {...link}>
          {console.log(link)}
          {icon}
          {title}
        </LinkContainer>
      ))
    ) : (
      <LinkContainer
        href={href}
        title={title}
        className={`${active}`}
        target={target}
      >
        {icon}
        {title}
      </LinkContainer>
    );
  };

  return <Link href={href}>{renderLinkDefault()}</Link>;
};
