import { LayoutContainer } from './styles';

type ContainerProps = {
  children: React.ReactNode;
};

const ContainerDefault: React.FC<ContainerProps> = ({ children }) => {
  return <LayoutContainer>{children}</LayoutContainer>;
};

export { ContainerDefault };
