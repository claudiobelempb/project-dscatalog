import { ReactDOM } from 'react';
import Link from 'next/link';
import { LinkContainer } from './styles';

type LinkProps = {
  icon?: ReactDOM;
  title: string;
  href: string;
  target: boolean;
  linkOnClick: () => void;
};

export const LinkDefault: React.FC<LinkProps> = ({
  title,
  href,
  target,
  linkOnClick,
  icon,
}) => {
  const tab = target ? '_blank' : '_self';

  const renderLink = () => {
    return (
      <LinkContainer>
        {icon}
        {title}
      </LinkContainer>
    );
  };

  return <Link href={href}>{renderLink()}</Link>;
};
